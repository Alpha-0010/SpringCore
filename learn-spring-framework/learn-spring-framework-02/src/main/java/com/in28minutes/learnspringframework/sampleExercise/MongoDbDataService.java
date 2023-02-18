package com.in28minutes.learnspringframework.sampleExercise;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MongoDbDataService implements DataService {
    @Override
    public int[] retrieveData() {
        return new int[]{1,2,10,9,8,11,70,111,101};
    }
}
