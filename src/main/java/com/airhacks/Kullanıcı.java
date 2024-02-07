package com.airhacks;

/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/

import java.util.Date;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@PersistenceCapable
public class Kullanıcı {

	@Persistent
	private Date oluşturmaTarihi;

	@Persistent
	private Date değiştirmeTarihi;

	@Persistent
	private String Hakkımda;

	@Persistent
	private String Meslek;

	@Persistent
	private String profilResmiUrl;

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.NATIVE)
	private long id;

	// TODO : sadece karekter kabulu pattern
	// eklenmeli
	@Size(max = 255)
	@Persistent
	private String kullanıcıAdı;

	// TODO : sadece karekter kabulu pattern
	// eklenmeli
	@Size(max = 255)
	@Persistent
	private String kullanıcıSoyadı;

	/**
	 * at the time this written datanucleus not supporting this Unique constraint
	 * for HBase because of HBase dont have that it looks like we have to seperate
	 * login services from application
	 * {@link http://www.datanucleus.org/products/datanucleus/jdo/orm/constraints.html#unique}
	 */
	@Unique
	@Persistent
	private String eMail;

	@NotNull
	@Persistent
	private boolean sistemeKullanıcıYerleştirmedeYetkili;

	@NotNull
	@Persistent
	private boolean yönetici;

	public Date getOluşturmaTarihi() {
		return oluşturmaTarihi;
	}

	public void setOluşturmaTarihi(Date oluşturmaTarihi) {
		this.oluşturmaTarihi = oluşturmaTarihi;
	}

	public Date getDeğiştirmeTarihi() {
		return değiştirmeTarihi;
	}

	public void setDeğiştirmeTarihi(Date değiştirmeTarihi) {
		this.değiştirmeTarihi = değiştirmeTarihi;
	}

	public String getHakkımda() {
		return Hakkımda;
	}

	public void setHakkımda(String hakkımda) {
		Hakkımda = hakkımda;
	}

	public String getMeslek() {
		return Meslek;
	}

	public void setMeslek(String meslek) {
		Meslek = meslek;
	}

	public String getProfilResmiUrl() {
		return profilResmiUrl;
	}

	public void setProfilResmiUrl(String profilResmiUrl) {
		this.profilResmiUrl = profilResmiUrl;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getKullanıcıAdı() {
		return kullanıcıAdı;
	}

	public void setKullanıcıAdı(String kullanıcıAdı) {
		this.kullanıcıAdı = kullanıcıAdı;
	}

	public String getKullanıcıSoyadı() {
		return kullanıcıSoyadı;
	}

	public void setKullanıcıSoyadı(String kullanıcıSoyadı) {
		this.kullanıcıSoyadı = kullanıcıSoyadı;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public boolean isSistemeKullanıcıYerleştirmedeYetkili() {
		return sistemeKullanıcıYerleştirmedeYetkili;
	}

	public void setSistemeKullanıcıYerleştirmedeYetkili(boolean sistemeKullanıcıYerleştirmedeYetkili) {
		this.sistemeKullanıcıYerleştirmedeYetkili = sistemeKullanıcıYerleştirmedeYetkili;
	}

	public boolean isYönetici() {
		return yönetici;
	}

	public void setYönetici(boolean yönetici) {
		this.yönetici = yönetici;
	}

}
