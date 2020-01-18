package com.roberto.hibernate.fouth_project.repository;

import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.roberto.hibernate.fouth_project.entity.Certificato;
import com.roberto.hibernate.fouth_project.entity.Impiegato;

public class ImpiegatoRepositoryTest {

	private static Logger log = Logger.getLogger("ImpiegatoRepositoryTest");
	private static ImpiegatoRepository impiegatoRepository = null;
	private static CertificatoRepository certificatoRepository = null;


	@BeforeClass
	public static void init() {
		log.info("class " + ImpiegatoRepositoryTest.class.getSimpleName() + "- method init() - START");
		impiegatoRepository = new ImpiegatoRepository();
		certificatoRepository = new CertificatoRepository();
		log.info("class " + ImpiegatoRepositoryTest.class.getSimpleName() + "- method init() - END");
	}
	
	@Test
	public void testCreateOKWithoutCeritificates() {
		log.info("class " + ImpiegatoRepositoryTest.class.getSimpleName() + "- method testCreateOKWithoutCeritificates() - START");
		Impiegato imp = (Impiegato) impiegatoRepository.getEntityForTest();
		Long retValue = impiegatoRepository.create(imp);
		assertTrue(retValue != -1);
		log.info("class " + ImpiegatoRepositoryTest.class.getSimpleName() + "- method testCreateOKWithoutCeritificates() - END");
	}
	
	@Test
	public void testCreateOKWithCeritificates() {
		log.info("class " + ImpiegatoRepositoryTest.class.getSimpleName() + "- method testCreateOKWithCeritificates() - START");
		Certificato cert1 = (Certificato)certificatoRepository.getEntityForTest();
		cert1.setNomeCertificato("ORACLE ASSOTATION");
		Certificato cert2 = (Certificato)certificatoRepository.getEntityForTest();
		cert2.setNomeCertificato("LINUX LPC1");
		Set<Certificato> certificati = new HashSet<Certificato>();
		certificati.add(cert1);
		certificati.add(cert2);
		Impiegato imp = (Impiegato) impiegatoRepository.getEntityForTest();
		imp.setCertificati(certificati);
		Long retValue = impiegatoRepository.create(imp);
		assertTrue(retValue != -1);
		log.info("class " + ImpiegatoRepositoryTest.class.getSimpleName() + "- method testCreateOKWithCeritificates() - END");
	}
}