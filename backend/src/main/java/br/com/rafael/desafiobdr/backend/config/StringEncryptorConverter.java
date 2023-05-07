package br.com.rafael.desafiobdr.backend.config;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class StringEncryptorConverter implements AttributeConverter<String, String> {

    private final PlacaEncryptor encryptor;

    public StringEncryptorConverter(PlacaEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    @Override
    public String convertToDatabaseColumn(String attribute) {
        return encryptor.encrypt(attribute);
    }

    @Override
    public String convertToEntityAttribute(String dbData) {
        return encryptor.decrypt(dbData);
    }
}