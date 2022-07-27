package com.sparta.week3.models;

import com.sparta.week3.utils.CommonResponse;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter@Setter
public class ListResponse extends CommonResponse {

   private List<Posting> dataList;

   public String error;
}
