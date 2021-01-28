package com.yuanbao.example.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;

@Data
@Document(indexName = "roles",type = "product",shards = 1,replicas = 0)
public class Roles implements Serializable {
    private static final long serialVersionUID=-1L;
    @Id
    private Integer id;
    @Field(type= FieldType.Keyword)
    private String name;
    private String love;
}
