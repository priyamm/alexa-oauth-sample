/*
 * Copyright 2019 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * Licensed under the Amazon Software License
 * http://aws.amazon.com/asl/
 */
package com.oauth.server.configuration;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for AWS DynamoDB Client.
 *
 * @author Lucun Cai
 */
@Configuration
public class DynamoDBConfiguration {

    @Bean
    public AmazonDynamoDB amazonDynamoDB() {
        BasicAWSCredentials awsCreds = new BasicAWSCredentials("AKIASZUAEII42GXL2BWQ", "YOH3uzczqopcRtUF+XU48Ypm/efHPMKwzSEPfobH");
        return AmazonDynamoDBClientBuilder.standard()
                .withRegion(Regions.US_EAST_2)
                   .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                   .build();
    }

    @Bean
    public DynamoDBMapper getDynamoDBMapper() {
        AmazonDynamoDB amazonDynamoDB = amazonDynamoDB();
        return new DynamoDBMapper(amazonDynamoDB);
    }
}
