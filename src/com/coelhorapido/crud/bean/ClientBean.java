package com.coelhorapido.crud.bean;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import com.coelhorapido.crud.dao.ClientDAO;
import com.coelhorapido.crud.model.Client;

@ManagedBean
@SessionScoped
public class ClientBean {
	private Client client;
	private ClientDAO clientDao;

	public ClientBean() {
		this.client = new Client();
		this.clientDao = new ClientDAO();
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public String saveClient() {

		if (this.client.getId() != 0L) {
			try {
				this.clientDao.update(this.client);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Sucesso!", "Cliente alterado com sucesso."));

			} catch (ClassNotFoundException | SQLException e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! aqui",
								"Cliente não foi alterado. " + e.getMessage()));
			}
			this.client = new Client();

		} else {
			try {
				this.clientDao.create(this.client);
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Sucesso!", "Cliente criado com sucesso."));

			} catch (ClassNotFoundException | SQLException e) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro! " + e.getMessage(),
								"Cliente não foi criado. " + e.getMessage()));
			}
			this.client = new Client();
		}

		return "index.xhtml";
	}

	public String destroyClient() {
		try {
			this.clientDao.destroy(this.client);
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!",
							"Cliente removido com sucesso."));

		} catch (ClassNotFoundException | SQLException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",
							"Cliente não foi removido. " + e.getMessage()));

		}
		this.client = new Client();

		return "index.xhtml";
	}
	
	public List<Client> getIndexClient() {
		List<Client> listClient = new ArrayList<Client>();
		
		try {
			listClient = clientDao.index();
		} catch (ClassNotFoundException | SQLException e) {
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!",
							"Cliente não listados. " + e.getMessage()));
		}
		
		return listClient;
	}
	
	public String updateClient(Client client) {
		this.client = client;
		return "index.html";
	}

}
