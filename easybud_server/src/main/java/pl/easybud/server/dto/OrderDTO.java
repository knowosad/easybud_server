package pl.easybud.server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderDTO {

  private Long id;
  private String label;
  private String name;
//  private String address; //TODO zmienić na encje
//  private LocalDateTime plannedStartDate;
//  private LocalDateTime plannedEndDate;
//  private LocalDateTime startDate;
//  private LocalDateTime endDate;
//  private String description;
//  private Integer contractorId ;  //TODO zmienić na encje
//  private LocalDateTime dateAdded;

  public OrderDTO(String label, String name) {
    this.label = label;
    this.name = name;
  }
}
