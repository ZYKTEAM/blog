package com.myblog.controller;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.action.update.UpdateResponse;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutionException;

/**
 * ES测试controller
 */
@RestController
public class BaseElasticSearchController {

    @Autowired
    private TransportClient client;

    /**
     * 根据索引+类型+id进行查询
     *
     * @param id
     * @return
     */
    @GetMapping("/get/zoology/cat")
    public ResponseEntity get(@RequestParam(name = "id", defaultValue = "") String id) {
        if (id.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        GetResponse result = client.prepareGet("zoology", "cat", id).get();
        if (!result.isExists()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(result.getSource(), HttpStatus.OK);
    }

    /**
     * 增加索引数据
     *
     * @param name
     * @param age
     * @param country
     * @param data
     * @return
     */
    @PostMapping("/add/zoology/cat")
    public ResponseEntity add(@RequestParam(name = "name") String name,
                              @RequestParam(name = "age") int age,
                              @RequestParam(name = "country") String country,
                              @RequestParam(name = "data") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") Date data
    ) {
        try {
            XContentBuilder content = XContentFactory.jsonBuilder().startObject().field("name", name).field("age", age).
                    field("country", country).endObject();
            IndexResponse result = client.prepareIndex("zoology", "cat").setSource(content).get();
            return new ResponseEntity(result.getId(), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 根据索引+类型+id进行删除
     *
     * @param id
     * @return
     */
    @DeleteMapping("/delete/zoology/cat")
    public ResponseEntity delete(@RequestParam(name = "id") String id) {
        if (id.isEmpty()) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        DeleteResponse result = client.prepareDelete("zoology", "cat", id).get();
        return new ResponseEntity(result.getResult().toString(), HttpStatus.OK);
    }

    @PutMapping("/update/zoology/cat")
    public ResponseEntity update(@RequestParam(name = "id") String id,
                                 @RequestParam(name = "name", required = false) String name,
                                 @RequestParam(name = "age", required = false) Integer age) {
        UpdateRequest update = new UpdateRequest("zoology", "cat", id);

        try {
            XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
            if (name != null) {
                builder.field("name", name);
            }
            if (age != null) {
                builder.field("age", age);
            }
            builder.endObject();
            update.doc(builder);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        try {
            UpdateResponse reuslt = client.update(update).get();
            return new ResponseEntity(reuslt.getResult().toString(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
