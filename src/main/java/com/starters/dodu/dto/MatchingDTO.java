package com.starters.dodu.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MatchingDTO {
  String inputDate = "2022-12-14T00:11:59";
  DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
  LocalDateTime dateTime = LocalDateTime.parse(inputDate, inputFormatter);

  DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초");
  String outputDate = dateTime.format(outputFormatter);

}
