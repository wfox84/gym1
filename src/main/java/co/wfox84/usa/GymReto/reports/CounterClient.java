package co.wfox84.usa.GymReto.reports;

import co.wfox84.usa.GymReto.model.Client;


public class CounterClient {
    private Long total;
    private Client client;

    public CounterClient(Long total, Client client) {
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
