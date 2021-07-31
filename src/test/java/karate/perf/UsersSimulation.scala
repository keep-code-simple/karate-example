package karate.perf

import com.intuit.karate.gatling.PreDef._
import io.gatling.core.Predef._
import scala.concurrent.duration._

class UsersSimulation extends Simulation {

  val protocol = karateProtocol(
    "/api/users" -> Nil,
    "/api/users/{id}" -> pauseFor("get" -> 15, "post" -> 25)
  )

  protocol.nameResolver = (req, ctx) => req.getHeader("karate-name")

  val createUsers = scenario("create users").exec(karateFeature("classpath:karate/example/users.feature"))
  val getUsers = scenario("get users").exec(karateFeature("classpath:karate/example/sample.feature@name=getUsers"))

  setUp(
    createUsers.inject(rampUsers(10) during (5 seconds)),
    getUsers.inject(rampUsers(5) during (5 seconds))
  ).protocols(protocol)

}