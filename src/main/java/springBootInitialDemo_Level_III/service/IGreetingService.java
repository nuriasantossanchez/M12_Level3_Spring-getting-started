package springBootInitialDemo_Level_III.service;

import springBootInitialDemo_Level_III.dto.GreetingResponseDto;

/**
 * Interface de la capa Service
 *
 */
public interface IGreetingService {

    GreetingResponseDto getGreeting(String greeting);
}
