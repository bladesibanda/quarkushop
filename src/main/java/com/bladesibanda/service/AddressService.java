package com.bladesibanda.service;

import com.bladesibanda.domain.Address;
import com.bladesibanda.web.dto.AddressDto;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AddressService {
  public static Address createFromDto(AddressDto addressDto) {
    return new Address(
        addressDto.getAddress1(),
        addressDto.getAddress2(),
        addressDto.getCity(),
        addressDto.getPostcode(),
        addressDto.getCountry());
  }

  public static AddressDto mapToDto(Address address) {
    return new AddressDto(
        address.getAddress1(),
        address.getAddress2(),
        address.getCity(),
        address.getPostcode(),
        address.getCountry());
  }
}
