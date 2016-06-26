package com.controller;

import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.db.H2DatabaseConnection;
import com.google.common.base.Joiner;

@SpringBootApplication
public class FuberApplication {
	private final static Logger log = LoggerFactory.getLogger(FuberApplication.class);
	private final static String[] fuberAppLogo = { "", " ________            _______   _______   _______ ",
			"|          |      | |       | |         |       |", "|________  |      | |     __| |_______  |     __|",
			"|          |      | |       | |         |    |__ ", "|          |______| |_______| |_______  |       |", };

	public static void main(String[] args) {
		try {
			H2DatabaseConnection.prepareDB();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpringApplication.run(FuberApplication.class, args);
		log.info(Joiner.on("\r\n").join(fuberAppLogo));

	}
}
