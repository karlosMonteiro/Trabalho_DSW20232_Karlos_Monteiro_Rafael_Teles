import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@FacesConverter("dateConverter")
public class DateConverter implements Converter {

    private final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        try {
            return sdf.parse(value);
        } catch (ParseException e) {
            throw new RuntimeException("Erro ao converter data", e);
        }
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return sdf.format((Date) value);
    }
}