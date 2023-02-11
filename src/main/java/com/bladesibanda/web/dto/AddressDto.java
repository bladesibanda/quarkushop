package com.bladesibanda.web.dto;

import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
  private String address1, address2, city, postcode;
  @Size(min = 2, max = 2)
  private String country;
}
