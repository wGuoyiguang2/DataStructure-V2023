package com.example.demo.entity.Vo;

import lombok.Data;

@Data
public class PermissionVo {
    public  String  id;
    public  String  name;
    public  String  url;
    public PermissionVo() {

    }
    public PermissionVo(String id, String name,String url) {
        this.id = id;
        this.name = name;
        this.url = url;
    }

}
