package br.com.rafael.desafiobdr.backend.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PlacaEncryptor {

    private final StandardPBEStringEncryptor encryptor;

    public PlacaEncryptor(@Qualifier("encryptorBean") StandardPBEStringEncryptor encryptor) {
        this.encryptor = encryptor;
    }

    public String encrypt(String placa) {
        return encryptor.encrypt(placa);
    }

    public String decrypt(String placa) {
        return encryptor.decrypt(placa);
    }
}
