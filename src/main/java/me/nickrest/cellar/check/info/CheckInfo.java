package me.nickrest.cellar.check.info;

import com.comphenix.protocol.PacketType;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface CheckInfo {
    String name();
    String type();
}
