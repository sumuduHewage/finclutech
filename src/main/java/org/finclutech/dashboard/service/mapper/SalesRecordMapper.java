package org.finclutech.dashboard.service.mapper;

import org.finclutech.dashboard.model.entity.SalesRecord;
import org.finclutech.dashboard.model.dto.SalesRecordDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;



@Mapper
public interface SalesRecordMapper {

    SalesRecordMapper INSTANCE = Mappers.getMapper(SalesRecordMapper.class);

    @Mapping(source = "businessCategory", target = "businessCategory")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "amount", target = "amount")
    SalesRecord toEntity(SalesRecordDTO dto);

    @Mapping(source = "businessCategory", target = "businessCategory")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "amount", target = "amount")
    SalesRecordDTO toDto(SalesRecord salesRecord);
}