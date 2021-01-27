package springBootInitialDemo_Level_III.repository;

import springBootInitialDemo_Level_III.dto.GreetingResponseDto;

/**
 * Interface de la capa Repository
 *
 */
public interface IGreetingRepository {

    public GreetingResponseDto getGreeting(String greeting);

}
