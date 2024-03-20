package com.mutualFundsManagment.mutualFundsManagment.Utility;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;


@Configuration
public class MutualFundMapper {

	private final ModelMapper modelMapper = new ModelMapper();


	// Method to convert Entity to DTO
    public <E, D> D convertToDto(E entity, Class<D> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    // Method to convert DTO to Entity
    public <E, D> E convertToEntity(D dto, Class<E> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}


//MutualFundMapper mapper = new MutualFundMapper();
//
////Using the mapper to convert entity to DTO
//MutualFundsDetailsDto dto = mapper.convertToDto(entity, MutualFundsDetailsDto.class);
//
////Using the mapper to convert DTO to entity
//MutualFundsDetails entity = mapper.convertToEntity(dto, MutualFundsDetails.class);