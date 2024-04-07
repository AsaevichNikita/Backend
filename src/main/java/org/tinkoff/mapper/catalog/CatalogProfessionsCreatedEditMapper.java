package org.tinkoff.mapper.catalog;

import org.springframework.stereotype.Component;
import org.tinkoff.database.entity.CatalogProfessions;
import org.tinkoff.database.entity.MentorHasCatalogProfessions;
import org.tinkoff.dto.catalog.CatalogProfessionsCreateEditDto;
import org.tinkoff.mapper.Mapper;

@Component
public class CatalogProfessionsCreatedEditMapper implements
        Mapper<CatalogProfessionsCreateEditDto, CatalogProfessions> {

    @Override
    public CatalogProfessions map(CatalogProfessionsCreateEditDto catalogProfessionsCreateEditDto) {
        CatalogProfessions catalogProfessions = new CatalogProfessions();
        catalogProfessions.setName(catalogProfessions.getName());
        return catalogProfessions;
    }

    @Override
    public CatalogProfessions map(CatalogProfessionsCreateEditDto catalogProfessionsCreateEditDto,
                                  CatalogProfessions catalogProfessions) {
        catalogProfessions.setName(catalogProfessionsCreateEditDto.getName());
        return catalogProfessions;
    }
}
