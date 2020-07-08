package util.dates.operation;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.function.Function;

import util.dates.model.DateGap;
import util.dates.model.EffExpModel;

public class DateSetter {

    void manageDates(List<EffExpModel> sources, List<EffExpModel> targets, Date effecDate, Date expDate) {
        sources.sort(Comparator.comparingLong(value -> value.getEffecDate().getTime()));
        int yearGap = 0, monthGap = 0, dateGap = 0;

    }

    /**
     * get date gap by years, months, dates.
     * if effective date : 2019-01-01, exp date 2020-02-02
     * Result : year ; 1, month 1, date 1
     * @param effExpModel
     * @return
     */
    DateGap getDateGap(EffExpModel effExpModel) {
        Date effectDate = effExpModel.getEffecDate();
        Date expDate = effExpModel.getExpDate();
        Function<Date, LocalDate> dateFunction = date -> {
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return LocalDate.of(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DATE));
        };
        Period period = Period.between(dateFunction.apply(effectDate), dateFunction.apply(expDate));
        DateGap gap = new DateGap();
        gap.setDate(period.getYears());
        gap.setMonth(period.getMonths());
        gap.setYear(period.getYears());
        return gap;
    }

}
