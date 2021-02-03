package com.yuanbao.example.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.mongodb.core.index.Indexed;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

@Data
@Document(indexName = "roles",type = "product",shards = 1,replicas = 0)
public class Roles implements Serializable {
    private static final long serialVersionUID=-1L;
    @Id
    private String id;
    @Indexed
    @Field(type= FieldType.Keyword)
    private String name;
    private String love;
    @Indexed
    private Date createTime;
}
