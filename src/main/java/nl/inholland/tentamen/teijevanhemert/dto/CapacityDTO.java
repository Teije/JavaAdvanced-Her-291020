package nl.inholland.tentamen.teijevanhemert.dto;

import lombok.Data;

@Data
public class CapacityDTO
{
    private int capacity;

    public CapacityDTO(int capacity)
    {
        this.capacity = capacity;
    }
}

