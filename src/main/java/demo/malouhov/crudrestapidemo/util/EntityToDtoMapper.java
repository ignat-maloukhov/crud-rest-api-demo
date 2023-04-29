package demo.malouhov.crudrestapidemo.util;

import demo.malouhov.crudrestapidemo.dto.GetCustomerDto;
import demo.malouhov.crudrestapidemo.dto.PostCustomerDto;
import demo.malouhov.crudrestapidemo.entity.CustomerEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EntityToDtoMapper {

    /**
     * Converts CustomerEntity to PostCustomerDto
     *
     * @param customerEntity - customerEntity object
     * @return - PostCustomerDto object
     */
    PostCustomerDto entityToPostDto(CustomerEntity customerEntity);

    /**
     * Converts PostCustomerDto to CustomerEntity
     *
     * @param postCustomerDto - postCustomerDto object
     * @return - CustomerEntity object
     */
    CustomerEntity postDtoToEntity(PostCustomerDto postCustomerDto);

    /**
     * Converts List of CustomerEntity to List of PostCustomerDto
     *
     * @param customerEntityList - List of CustomerEntity objects
     * @return - List of PostCustomerDto objects
     */
    List<PostCustomerDto> entityListToPostDtoList(List<CustomerEntity> customerEntityList);

    /**
     * Converts List of PostCustomerDto to List of CustomerEntity
     *
     * @param postCustomerDtoList - List of PostCustomerDto objects
     * @return - List of CustomerEntity objects
     */
    List<CustomerEntity> postDtoListToEntityList(List<PostCustomerDto> postCustomerDtoList);

    /**
     * Converts CustomerEntity to GetCustomerDto
     *
     * @param customerEntity - CustomerEntity object
     * @return - GetCustomerDto object
     */
    GetCustomerDto entityToGetDto(CustomerEntity customerEntity);

    /**
     * Converts GetCustomerDto to CustomerEntity
     *
     * @param getCustomerDto - GetCustomerDto object
     * @return - CustomerEntity object
     */
    CustomerEntity getDtoToEntity(GetCustomerDto getCustomerDto);

    /**
     * Converts List of CustomerEntity to List of GetCustomerDto
     *
     * @param customerEntityList - List of CustomerEntity objects
     * @return - List of GetCustomerDto objects
     */
    List<GetCustomerDto> entityListToGetDtoList(List<CustomerEntity> customerEntityList);

    /**
     * Converts List of GetCustomerDto to List of CustomerEntity
     *
     * @param getCustomerDtoList - List of GetCustomerDto objects
     * @return - List of CustomerEntity objects
     */
    List<CustomerEntity> getDtoListToEntityList(List<GetCustomerDto> getCustomerDtoList);

}
