package com.example.authservice.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 *
 * @param <S> - Source type parameter.
 * @param <D> - Destination parameter.
 */

public interface BaseMapper<S, D> {
    S toSource(D destination);

    D toDestination(S source);

    List<S> toSource(List<D> destinationList);

    List<D> toDestination(List<S> sourceList);

    @Named("partialUpdate")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void partialUpdate(@MappingTarget S source, D destination);
}
