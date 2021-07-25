# karate-example
This is an example project on how to set up karate

Please run the below test from TestRunner class

    @Test
    public void testParallel() {
        Results results = Runner.path("classpath:karate/example").tags("@e2e").parallel(5);
        assertTrue(results.getErrorMessages(), results.getFailCount() == 0);
    }



