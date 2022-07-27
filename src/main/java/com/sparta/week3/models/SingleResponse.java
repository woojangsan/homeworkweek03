package com.sparta.week3.models;

import com.sparta.week3.utils.CommonResponse;
import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class SingleResponse extends CommonResponse {

    Posting data;

    public String error;

}
