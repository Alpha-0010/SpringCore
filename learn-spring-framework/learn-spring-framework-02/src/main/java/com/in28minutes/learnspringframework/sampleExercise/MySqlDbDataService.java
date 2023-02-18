package com.in28minutes.learnspringframework.sampleExercise;

import org.springframework.stereotype.Component;

@Component
public class MySqlDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{100,91,99,10,1,2,101};
    }
}
