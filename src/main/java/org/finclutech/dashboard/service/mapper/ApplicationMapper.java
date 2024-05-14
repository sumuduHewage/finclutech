package org.finclutech.dashboard.service.mapper;

import org.finclutech.dashboard.model.dto.ApplicationDTO;
import org.finclutech.dashboard.model.entity.Application;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {

    ApplicationMapper INSTANCE = Mappers.getMapper(ApplicationMapper.class);

    Application toEntity(ApplicationDTO applicationDTO);

    ApplicationDTO toDto(Application application);
}
