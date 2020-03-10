package pl.easybud.server.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContractorDTO {

  private Long id;
  private String label;
  private String name;
//  private String nip;
//  private String phone;
//  private String state;
//  private String added;
//  private String addedBy;
//  private Boolean owner;
//  private Boolean defined;
//  private String address; //TODO w przyszłości zmienić na encje
}
