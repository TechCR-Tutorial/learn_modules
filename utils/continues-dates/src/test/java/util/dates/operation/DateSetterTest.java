package util.dates.operation;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

import org.testng.Assert;
import org.testng.annotations.Test;

import util.dates.model.DateGap;
import util.dates.model.EffExpModel;

import static org.testng.Assert.*;

public class DateSetterTest {

    @Test
    public void testGetDateGap() {
        DateSetter dateSetter = new DateSetter();
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 0, 1);
        Date effectDate = calendar.getTime();

        calendar.set(2019, 3, 1);
        Date expDate = calendar.getTime();

        EffExpModel effExpModel = new EffExpModel(effectDate, expDate);
        DateGap gap = dateSetter.getDateGap(effExpModel);
        Assert.assertEquals(gap.getYear(), 0);
        Assert.assertEquals(gap.getMonth(), 1);
        Assert.assertEquals(gap.getDate(), 0);

    }
}