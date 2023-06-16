package com.kunintns.kafka_web_message.Vo;

import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageVO {

   public String id;
   public String position;
   public String longitude;
   public String latitude;
   public String time;

}
