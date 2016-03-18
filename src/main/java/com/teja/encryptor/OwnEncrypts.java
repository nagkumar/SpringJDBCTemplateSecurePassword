package com.teja.encryptor;

import org.jasypt.encryption.pbe.config.EnvironmentStringPBEConfig;

import java.io.Console;
import java.util.Base64;

public final class OwnEncrypts extends EnvironmentStringPBEConfig
{
    public OwnEncrypts()
    {
	final Console cnsl = System.console();
	char[] pwdChars = null;
	if (cnsl != null)
	{
	    pwdChars = cnsl.readPassword("Password: ");
	}
	final String pwd = (pwdChars != null) ? new String(pwdChars) : new String(Base64.getDecoder().decode("bm9uc2Vuc2U="));
	setPassword(pwd);
    }
}
