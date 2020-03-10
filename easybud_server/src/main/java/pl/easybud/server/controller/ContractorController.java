package pl.easybud.server.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.easybud.server.dto.ContractorDTO;
import pl.easybud.server.service.ContractorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contractors")
public class ContractorController {

  private ContractorService contractorService;

  @PostMapping
  public ContractorDTO create(@RequestBody ContractorDTO dto){
    return contractorService.create(dto);
  }

}
