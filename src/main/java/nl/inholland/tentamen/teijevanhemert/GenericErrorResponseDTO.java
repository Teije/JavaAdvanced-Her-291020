package nl.inholland.tentamen.teijevanhemert;

import lombok.Data;

import java.time.Instant;

@Data
public class GenericErrorResponseDTO
{
    private int status;
    private Object message;
    private Instant timestamp;

    public GenericErrorResponseDTO(int status, Object message)
    {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp.now();
    }
}
