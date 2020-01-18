package com.roberto.hibernate.fouth_project.repository;

import static org.junit.Assert.assertTrue;

import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.roberto.hibernate.fouth_project.entity.Impiegato;

public class CertificatoRepositoryTest {

	private static Logger log = Logger.getLogger("CertificatoRepositoryTest");
	private static CertificatoRepository certificatoRepository = null;

	@BeforeClass
	public static void init() {
		log.info("class " + CertificatoRepositoryTest.class.getSimpleName() + "- method init() - START");
		certificatoRepository = new CertificatoRepository();
		log.info("class " + CertificatoRepositoryTest.class.getSimpleName() + "- method init() - END");
	}
	
	@Test
	public void testCreateOK() {
		log.info("class " + CertificatoRepositoryTest.class.getSimpleName() + "- method testCreateOK() - START");
		log.info("class " + CertificatoRepositoryTest.class.getSimpleName() + "- method testCreateOK() - END");
	}
}
