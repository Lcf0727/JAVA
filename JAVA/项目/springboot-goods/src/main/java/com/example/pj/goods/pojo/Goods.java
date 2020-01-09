package com.example.pj.goods.pojo;

import java.util.Date;

import lombok.Data;

@Data
public class Goods {
	private Integer id;
	private String name;
	private String remark;
	private Date createdTime;
}
