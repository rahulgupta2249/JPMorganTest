package org.jpmorgan.payload;

import org.jpmorgan.utils.RandomDataGenerator;
import org.jpmorgan.models.MakePostDTO;

public class MakePostPayload implements Payload {


    public MakePostDTO createPayloadFromPojo() {

            return  MakePostDTO.builder()
                    .setUserId(Integer.valueOf(RandomDataGenerator.createRandomNumber(6)))
                    .setTitle(RandomDataGenerator.generateTitle())
                    .setBody(RandomDataGenerator.createRandomString(20))
                    .build();

    }
}
