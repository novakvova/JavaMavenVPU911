package program.mapper;

import org.mapstruct.Mapper;
import program.dto.admin.roledto.RoleAddDto;
import program.entities.Role;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    Role RoleByAddRoleDto(RoleAddDto dto);
}
