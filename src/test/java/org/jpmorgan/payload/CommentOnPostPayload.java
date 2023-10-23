package org.jpmorgan.payload;

import org.jpmorgan.utils.RandomDataGenerator;
import org.jpmorgan.models.CommentOnPostDTO;

public class CommentOnPostPayload implements Payload{

    public CommentOnPostDTO createPayloadFromPojo() {

        return CommentOnPostDTO.builder()
                .setName(RandomDataGenerator.generateFullName())
                .setEmail(RandomDataGenerator.generateEmailAddress())
                .setBody(RandomDataGenerator.createRandomString(50))
                .build();
    }
}
