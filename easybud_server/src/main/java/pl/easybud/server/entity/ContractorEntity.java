package pl.easybud.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "T_CONTRACTORS")
@NoArgsConstructor
public class ContractorEntity {

  @Id
  private Long id;

  @Column(name = "label")
  private String label;

  @Column(name = "name")
  private String name;

//  @Column(name = "nip")
//  private String nip;
//
//  @Column(name = "phone")
//  private String phone;
//
//  @Column(name = "state")
//  private String state;
//
//  @Column(name = "added")
//  private String added;
//
//  @Column(name = "added_by")
//  private String addedBy;
//
//  @Column(name = "owner")
//  private Boolean owner;
//
//  @Column(name = "defined")
//  private Boolean defined;
//
//  @Column(name = "address_id")
//  private String address; //TODO w przyszłości zmienić na encje

  public ContractorEntity(Long id, String label, String name) {
    this.id = id;
    this.label = label;
    this.name = name;
  }
}
