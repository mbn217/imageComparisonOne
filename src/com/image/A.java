package com.image;

import java.io.File;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.api.errors.GitAPIException;
import org.eclipse.jgit.api.errors.InvalidRemoteException;
import org.eclipse.jgit.api.errors.TransportException;
import org.eclipse.jgit.transport.JschConfigSessionFactory;
import org.eclipse.jgit.transport.OpenSshConfig;
import org.eclipse.jgit.transport.SshSessionFactory;
import org.eclipse.jgit.transport.SshTransport;
import org.eclipse.jgit.transport.Transport;
import org.eclipse.jgit.transport.TransportHttp;

import com.jcraft.jsch.Session;

public class A {
	public static void main(String[] args) throws InvalidRemoteException, TransportException, GitAPIException {
      Git.cloneRepository()
      .setURI("git@git.fda.gov:FDA/CDER/BITM/pratsutilities.git")
      .setDirectory(new File("C:\\Users\\Mohamed.Nheri\\DevOps\\New folder")) 
      .call();
		}
	
	public static TransportConfigCallback getTransportConfigCallback()
    {
           final SshSessionFactory sshSessionFactory = new JschConfigSessionFactory() {
                  @Override
                  protected void configure(OpenSshConfig.Host host, Session session)
                  {
                        session.setConfig("StrictHostKeyChecking", "no");
                  }
           };
           return new TransportConfigCallback() {

                  @Override
                  public void configure(Transport transport)
                  {
                        if (transport instanceof TransportHttp)
                               return;
                        SshTransport sshTransport = (SshTransport) transport;
                        sshTransport.setSshSessionFactory(sshSessionFactory);
                  }
           };
    }

	

}
