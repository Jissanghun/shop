package com.shop.dto;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ShopDTO {
    private String id;
    private String name;
    private String location;
    private String tel;
    private String imgname; //ㅇㅁㅈ
    private double lat; //위도
    private double lng; //경도
    private String sido_Code;

    private MultipartFile img;
}
