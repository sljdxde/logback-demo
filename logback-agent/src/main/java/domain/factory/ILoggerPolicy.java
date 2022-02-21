package domain.factory;


import domain.entity.LogEntity;

public interface ILoggerPolicy {

    void save(LogEntity logEntity);


}
