package org.finclutech.dashboard.service.mapper;

import org.finclutech.dashboard.model.dto.ApplicationDTO;
import org.finclutech.dashboard.model.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);
    @Mapping(target = "id", source = "id")
    Application toEntity(ApplicationDTO applicationDTO);
    @Mapping(target = "id", source = "id")
    ApplicationDTO toDto(Application application);
}
