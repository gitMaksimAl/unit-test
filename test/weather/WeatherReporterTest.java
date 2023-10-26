package test.weather;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Lesson_4.weather.WeatherReporter;
import Lesson_4.weather.WeatherService;

class WeatherReporterTest {

    @Test
    public void reporterTest() {
        WeatherService service = mock(WeatherService.class);
        when(service.getCurrentTemperature()).thenReturn(31);

        WeatherReporter reporter = new WeatherReporter(service);
        assertThat(reporter.generateReport()).isEqualTo("Текущая температура: 31 градусов.");
    }
}