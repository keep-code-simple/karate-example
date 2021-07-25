# karate-example
This is an example project on how to set up karate

Please run the below test from TestRunner class

    @Test
    public void testParallel() {
        Results results = Runner.path("classpath:karate/example").tags("@e2e").parallel(5);
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }

Note: There are great examples at karate officail demo repo https://github.com/intuit/karate/tree/master/karate-demo/src/test/java/demo

