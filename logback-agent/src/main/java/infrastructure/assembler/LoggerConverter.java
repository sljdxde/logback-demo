package infrastructure.assembler;


import domain.entity.LogEntity;

public class LoggerConverter {

    public String logEntityToString(LogEntity logEntity) {
        return logEntity.logCommendToString();
    }
}
