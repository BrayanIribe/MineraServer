package minera.server.service;

import java.util.List;

import minera.server.model.Congestion;

public interface CongestionService {

    public List<Congestion> find();

    public Congestion findFirstById(Integer id) throws Exception;

    public Integer create(Congestion congestion) throws Exception;

    public Boolean update(Congestion congestion) throws Exception;

    public Boolean delete(Integer id) throws Exception;

}
